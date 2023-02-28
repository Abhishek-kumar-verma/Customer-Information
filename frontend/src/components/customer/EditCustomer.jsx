import axios from 'axios';
import React, { useState } from 'react'
import { useEffect } from 'react';
import { Link } from 'react-router-dom';
import AddCustomer from './AddCustomer';
import UpdateCustomer from './UpdateCustomer';

const EditCustomer = () => {
  const[editId,setEditId]= useState('');
  const[exist,setExist] = useState('');
  useEffect(()=>{
    const loadDetails = async() =>{
      const idResponse = await axios.get(`http://localhost:8035/customerExist/${editId}`);
      console.log(await idResponse.data);
      setExist( await idResponse.data);
    }
    loadDetails();
  },[editId]);
  const onInputChange =(e)=>{
    // console.log(idResponse.data);
    if(e.target.value != null ){
      
      setEditId(e.target.value);
      console.log(editId);
    }
    
  }

  return (
    <div className='container'>
      <h2>Edit Customer</h2>
      <div class="input-group mb-6">
        <span class="input-group-text" id="basic-addon1">@</span>
        <input type="number" class="form-control" placeholder="Enter the Customer Id " onChange={(e)=>onInputChange(e)}/>
      </div>
      {exist ? <Link className='btn btn-secondary m-5' 
                                  to={`/UpdateCustomer/${editId}`}
                                  >Update</Link> : <><br></br><h4 className='error text-danger font-size-lg'>Please Enter valid id</h4></>}
      {/* <Link className='btn btn-secondary m-5' 
                                  to={`/UpdateCustomer/${editId}`}
                                  >Update</Link> */}
    </div>
  )
}

export default EditCustomer