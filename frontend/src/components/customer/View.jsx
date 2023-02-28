// import React from 'react'
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
const View = () => {
    const[customer , setCustomer] = useState("")
    
      const {id} = useParams();
    
      useEffect( ()=>{
         loadCustomer(id);
      },[])
    
      const loadCustomer = async(id)=>{
        const result = await axios.get(`http://localhost:8035/getCustomerById/${id}`);
        setCustomer(await result.data);
      }
      return (
        <div className='container mt-4 .bg-dark.bg-gradient'>
                <div className='row'>
                    <div className='col-md-6 offset-md-3 border rounded p-4 mt-3 shadow'>
                        <h2 className='text-centre m-4'>Customer Details</h2>
    
              <div className='card'>
                 <div className='card-header'>
                    <b className='text-danger '>Customer id :{customer.id}</b>
                    <ul className='list-group list-group-flush'>
                        <li className='list-group-item'>
                           <b>Name : </b>
                           {customer.name}
                        </li>
                        <li className='list-group-item'>
                           <b>Tenant name : </b>
                           {customer.tenant}
                        </li>
                        <li className='list-group-item'>
                           <b>email : </b>
                           {customer.contact_email}
                        </li>
                        <li className='list-group-item'>
                           <b>contact Phone : </b>
                           {customer.contact_phone}
                        </li>
                        <li className='list-group-item'>
                           <b>Country : </b>
                           {customer.country}
                        </li>
                        <li className='list-group-item'>
                           <b>state : </b>
                           {customer.state}
                        </li>
                        <li className='list-group-item'>
                           <b>city : </b>
                           {customer.city}
                        </li>
                        <li className='list-group-item'>
                           <b>isActive : </b>
                           {JSON.stringify(customer.is_active)}
                        </li>
                        <li className='list-group-item'>
                           <b>violation_category : </b>
                           {customer.violation_category}
                        </li>
                        <li className='list-group-item'>
                           <b>zip : </b>
                           {customer.zip}
                        </li>
                    </ul>
                 </div>
              </div>
              <Link className='btn btn-primary my-3' to={"/"}>Back To Home</Link>
            </div>
          </div>
        </div>
      )
}

export default View