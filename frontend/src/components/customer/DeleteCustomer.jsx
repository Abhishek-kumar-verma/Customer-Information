import React from 'react'
import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { useEffect } from 'react';
const DeleteCustomer = () => {
  let navigate = useNavigate();
  const[deleteId,setDeleteId]= useState('');
  const[exist,setExist] = useState('')
  useEffect(()=>{
    const loadDetails = async() =>{
      const idResponse = await axios.get(`http://localhost:8035/customerExist/${deleteId}`);
      console.log(await idResponse.data);
      setExist( await idResponse.data);
    }
    loadDetails();
  },[deleteId]);
  const onInputChange =(e)=>{
    if(e.target.value != null){
      setDeleteId(e.target.value);
      console.log(deleteId);
    }
  }
  const deleteProduct = async(id)=>{
    
    const del = window.confirm(`Are Sure You want to delete this Customer with ${id}`)
    console.log(del);
    if( del){
        
        await axios.delete(`http://localhost:8035/deleteCustomerById/${deleteId}`);
        // loadProducts();
        //setTimeout(1000);
        alert(`Customer deleted which id is ${deleteId}`);
        navigate("/");
    }
   // loadProducts();
    
}
  return (
    <div className='container'>
      <h2>Delete Customer</h2>
      <div class="input-group mb-6">
        <span class="input-group-text" id="basic-addon1">@</span>
        <input type="number" class="form-control" placeholder="Enter the Customer Id " onChange={(e)=>onInputChange(e)}/>
      </div>
      { exist ? <button className='btn btn-danger m-5' onClick={()=>deleteProduct(deleteId)}>Delete</button> 
      : <><br></br><h4 className='error text-danger font-size-lg'>Please Enter valid id</h4></>}
               
      
    </div>
  )
}

export default DeleteCustomer