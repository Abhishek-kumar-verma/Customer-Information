// import React from 'react'
import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useParams } from 'react-router-dom';
const Home = () => {
  const[customers,setCustomers] = useState([]);
  const {id} = useParams();
  useEffect(()=>{
      loadProducts();
  },[]);

  const loadProducts = async()=>{
      const result = await axios.get("http://localhost:8035/getAllCustomer");
      setCustomers( await result.data);
  }

  const deleteProduct = async(id)=>{
      const del = window.confirm(`Are Sure You want to delete this Customer with ${id}`)
      console.log(del);
      if( del){
          
          await axios.delete(`http://localhost:8035/deleteCustomerById/${id}`);
          loadProducts();
          //setTimeout(1000);
          alert(`Customer deleted which id is ${id}`);
      }
     // loadProducts();
      
  }
  return (
      <div className='container'>
          <div className='py-4'>
              <table className="table border shadow">
                  <thead className='border-dark bold'>
                      <tr>
                          <th scope="col">Tenant</th>
                          <th scope="col">Customer Name</th>
                          <th scope="col">Address</th>
                          <th scope="col">State</th>
                          <th scope="col">City</th>
                          <th scope='col'>Email</th>
                      </tr>
                  </thead>
                  <tbody>
                      {
                          customers.map( (customer,index)=>(
                            
                            (<tr>
                              <td scope="row" key={index}>{customer.tenant}</td>
                              <td>{customer.name}</td>
                              <td>{customer.address}</td>
                              <td>{customer.state}</td>
                              <td>{customer.city}</td>
                              <td>{customer.contact_email}</td>
                              <td>
                                  <Link className='btn btn-primary mx-2' 
                                  to={`/CustomerView/${customer.id}`}
                                  >View</Link>
                                  <Link className='btn btn-secondary mx-2' 
                                  to={`/UpdateCustomer/${customer.id}`}
                                  >Update</Link>
                                  <button className='btn btn-danger mx-2' onClick={()=>deleteProduct(customer.id)}>Delete</button>
                              </td>
                            </tr>) 
                          ))
                      }
                      
                  </tbody>
              </table>
          </div>

      </div>
  )
}

export default Home