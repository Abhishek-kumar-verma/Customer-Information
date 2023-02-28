import axios from 'axios';
import React, { Component, useEffect, useState } from 'react'

import { Link, useNavigate } from 'react-router-dom'

const AddCustomer = () => {
    let navigate = useNavigate();
    const [tenants, setTenants] = useState([]);
    const [countries, setCountries] = useState([]);
    const [countryId, setCountryId] = useState(0);
    const [states, setStates] = useState([]);
    const [stateId, setStateId] = useState(0);
    const [cities, setCities] = useState([]);
    const [cityId, setCityId] = useState(0);
    const [zipCode, setZipCode] = useState("");
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [address, setAddress] = useState("");
    const [contact_phone, setContact_Phone] = useState("");
    const [contact_name, setContact_Name] = useState("");
    const [contact_email, setContact_Email] = useState("");
    const [tenant, setTenant] = useState("");
    const [is_active, setIs_Active] = useState("");
    const [violation_category, setViolation_Category] = useState([]);
    const [country, setCountry] = useState("");
    const [state, setState] = useState("");
    const [city, setCity] = useState("");
    const [zip, setZip] = useState("");
    const [error, setError] = useState(false);
    
    const date = new Date();
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();

    // This arrangement can be altered based on how we want the date's format to appear.
    let currentDate = `${year}-${month}-${day}`;
    // console.log(currentDate); // "17-6-2022"

    // const [customer, setCustomer] = useState({
    //     name: " ",
    //     description:" ",
    //     address:" ",
    //     contact_email:" ",
    //     country:" ",
    //     state:" ",
    //     city:" ",
    //     zip:" ",
    //     contact_name:" ",
    //     contact_phone:" ",
    //     violation_category:[],
    //     is_active:false,
    //     tenant:" "
    // })

    // const {name,description,address,contact_email,country,state,city,zip,
    //     contact_name,contact_phone,violation_category,is_active,tenant}=customer;

    const onInputChange = (e) => {
        console.log(e);
        // console.log(e.target);
        console.log(e.target.options);
        // setCustomer({ ...customer, [e.target.name]: e.target.value })
        // console.log(customer);
    }
    const onSubmitBtn = async (e) => {
        e.preventDefault();
        //console.log(customer);
        // console.log(country+" "+state+" "+city+" "+" "+tenant);
        if (tenant.length === 0 || city.length === 0 || name.length === 0 || contact_email.length === 0 || country.length === 0 || state.length === 0 || zip == "" || contact_phone == "" || violation_category.length < 1) {
            setError(true);
        }
        if (tenant && city && name && contact_email && country && state && zip && contact_phone.length && violation_category.length >= 1) {
            const response = await axios.post("http://localhost:8035/addCustomer", {
                name: name,
                description: description,
                address: address,
                contact_email: contact_email,
                country: country,
                state: state,
                city: city,
                zip: zip,
                contact_name: contact_name,
                contact_phone: contact_phone,
                violation_category: violation_category,
                is_active: is_active,
                tenant: tenant,
                created_date: date
            });
            console.log(await response.data);
            alert("New Customer Added");
            navigate("/");
        }
        else {
            alert("Failed ! please provide required field");
        }

    }
    useEffect(() => {
        loadDetails();
        // setActive();

        // setParking();

        //   countryChange();;
    }, []);

    const loadDetails = async () => {
        const response = await axios.get("http://localhost:8035/getAllTenant");
        setTenants(response.data);
        //console.log(tenant);
        const countryResponse = await axios.get("http://localhost:8035/getAllCountries");
        setCountries(countryResponse.data);
        console.log(countryResponse.data);


    }
    const onChangeTenant = (e) =>{
        setTenant(e.target.value);
    }
    const countryChange = (e) => {
        var index = e.target.options.selectedIndex;
        var optionElement = e.target[index];
        var option = optionElement.getAttribute('data-id');
        //console.log(e.target.options.selectedValue);
        setCountryId(option);

    }
    useEffect(() => {
        const getState = async () => {
            const stateResponse = await axios.get(`http://localhost:8035/getStatesByCountryId/${countryId}`);
            setStates(await stateResponse.data);
        }
        getState();
    }, [countryId])

    const stateChange = (e) => {
        // console.log(e.target.key);
        var index = e.target.options.selectedIndex;
        var optionElement = e.target[index];
        var option = optionElement.getAttribute('data-id');
        //console.log(e.target.options.selectedIndex);
        setStateId(option);
    }
    useEffect(() => {
        const getCities = async () => {
            console.log(stateId);
            const citiesResponse = await axios.get(`http://localhost:8035/getCitiesByStateId/${stateId}`);
            console.log(await citiesResponse.data);
            setCities(await citiesResponse.data);
            console.log("city fetched");
        }
        getCities();
    }, [stateId]);

    const cityChange = (e) => {
        var index = e.target.options.selectedIndex;
        var optionElement = e.target[index];
        var option = optionElement.getAttribute('data-id');
        //console.log(option);
        setCityId(option);
        console.log(cityId);
    }

    const zipResponse = async () => {
        let z = await axios.get(`http://localhost:8035/getZipCodeByCityId/${cityId}`);
        setZip(await z.data);
        console.log(zip);
    }
    useEffect(() => {
        zipResponse();
    }, [cityId])
    // useEffect( ()=>{
    //     const getZipCode = cit
    // })
    const setActive = () => {
        setIs_Active(!is_active);
        console.log(is_active);
    }
    const setViolation = (e) => {
        if (e.target.checked) {
            setViolation_Category(violation_category.concat(e.target.value))
        } else {
            const index = violation_category.indexOf(e.target.value);
            violation_category.splice(index, 1);
            setViolation_Category(violation_category);
        }
        console.log(violation_category);
    }
    // const onChangeTenant = (e)=>{
    //     // setTenant(e.target.value);
    //     // let index = e.target.options.selectedIndex;
    //     // console.log(e.target.key);
    //     var index = e.target.options.selectedIndex;
    //     var optionElement = e.target[index];
    //     console.log(optionElement)
    //     var option = optionElement.getAttribute('data-id');
    //     setTenant(e.target.value);
    // }
    const onChangeDescription = (e) => {

        setDescription(e.target.value);
        // if( description.length > 500){
        //     alert("description word max limit increases");
        // }
    }

    const resetForm = () => {
        
        setActive('');
        setAddress('');
        setCity('');
        setCountry('');
        setTenant('');
        setContact_Email('')
        setContact_Name('')
        setContact_Phone('')
        setZip('');
        setActive('')
        setName('');
        setViolation_Category('')
        setDescription('');
    }
    return (
        <div>
            <div className='container mt-4 .bg-dark.bg-gradient'>
                <div className='row'>
                    <div className='col-md-13 offset-md-0.5 border rounded p-2 mt-2 shadow'>
                        <h3 className='text-centre m-4'>ADD CUSTOMER</h3>
                        <form className="row center-block" onSubmit={(e) => onSubmitBtn(e)}>
                            <div className='col-md-5 mx-4'>
                                <div className="mb-3 row p-1">
                                    <label for="inputTenant" className="col-sm-2 col-form-label" >*Tenant</label>
                                    <div className="col-sm-10">
                                        <select type="text" className="form-select" id="inputTenant" onChange={(e) => onChangeTenant(e)} >
                                            <option selected disabled data-id={0}>---select Tenant ---</option>
                                            {
                                                tenants.map(obj => (
                                                    (obj.is_deleted == false ? 
                                                        <option name="tenant" value={obj.tenant_name} data-id={obj.tenant_id} >{obj.tenant_name}</option> : ""
                                                    )  
                                                ))
                                            }
                                        </select>
                                        {error && tenant.length == 0 ?
                                            <lable id="data" className="error text-danger" >tenant is required feild</lable> : ""
                                        }
                                    </div>
                                </div>
                                <div className="mb-3 row p-1">
                                    <label for="inputDescription " className="col-sm-2 col-form-label">*Description</label>
                                    <div className="col-sm-10">
                                        <textarea type="text" maxlength="500" name="description" value={description} className="form-control" rows="5" onChange={(e) => onChangeDescription(e)}></textarea>
                                    </div>

                                </div>

                                <div className="mb-3 row p-1">
                                    <label for="inputState" className="col-sm-2 col-form-label">*State</label>
                                    <div className="col-sm-10">
                                        <select className="form-select has-invalid" id="inputState" onChange={(e) => { stateChange(e); setState(e.target.value) }} >
                                            <option selected disabled value="">-- select State -- </option>
                                            {
                                                states.map(obj => (
                                                    ( obj.is_deleted == false ?
                                                    <option name="state" value={obj.state_name} data-id={obj.state_id} >{obj.state_name}</option> : ""
                                                    )
                                                ))
                                            }
                                        </select>

                                        {error && state.length == 0 ?
                                            <lable className="error text-danger" >State is required </lable> : ""
                                        }

                                    </div>
                                </div>

                                <div className="mb-3 row p-1">
                                    <label for="inputCity" className="col-sm-2 col-form-label">*City</label>
                                    <div className="col-sm-10">
                                        <select className="form-select has-invalid" id="inputCity" onChange={(e) => { cityChange(e); setCity(e.target.value) }} >
                                            <option selected disabled value="">-- select City -- </option>
                                            {
                                                cities.map(obj => (
                                                    ( obj.is_deleted == false ?
                                                        <option name="city" value={obj.city_name} data-id={obj.city_id}>{obj.city_name}</option> : ""
                                                    )
                                                ))

                                            }
                                        </select>

                                        {error && city.length == 0 ?
                                            <lable className="error text-danger" >City is required</lable> : ""
                                        }
                                    </div>
                                </div>
                                <div className="mb-3 row p-1">
                                    <label for="inputContactPhone" className="col-sm-2 col-form-label">*Contact Phone</label>
                                    <div className="col-sm-10">
                                        <input className="form-control" id="inputPhone" name="contact_phone" value={contact_phone} onChange={(e) => setContact_Phone(e.target.value)} />

                                        {error && contact_phone.length == 0 ?
                                            <lable className="error text-danger" >Phone is required</lable> : ""}
                                    </div>
                                </div>
                                <div className='mb-3 row center'>
                                    <label for="checkValidationCategory" className='col-sm-2 col-form-label'>*Validation Category</label>
                                    <div className="col-sm-10 py-3">
                                        <input type="checkbox" value="HOA" name="violation_category" onChange={(e) => setViolation(e)}></input>
                                        <label className="mx-2" htmlFor='violation_category'>HAO</label>
                                        <input type="checkbox" value="Parking" name="violation_category" onChange={(e) => setViolation(e)}></input>
                                        <label className="px-2" htmlFor='violation_category'>Parking</label>
                                    </div>

                                    {error && violation_category.length < 1 ?
                                        <lable className="error text-danger" >please choose  atleast one</lable> : ""}
                                </div>
                            </div>
                            <div className='col-md-6 '>
                                <div className="mb-3 row ">
                                    <label for="inputCustomerName" className="col-sm-2 col-form-label">*Customer Name</label>
                                    <div className="col-sm-10">
                                        <input className="form-control" id="inputCustomerName" name="name" value={name} onChange={(e) => setName(e.target.value)} />

                                        {error && name.length == 0 ?
                                            <lable className="error text-danger" >Name is required</lable> : ""}
                                    </div>
                                </div>
                                <div className="mb-3 row p-1">
                                    <label for="inputAddress" className="col-sm-2 col-form-label">*Address</label>
                                    <div className="col-sm-10">
                                        <input className="form-control" id="inputAddress" name="address" value={address} onChange={(e) => setAddress(e.target.value)} />
                                        <br></br>
                                        {error && address.length == 0 ?
                                            <lable className="error" >Address is required</lable> : ""}
                                    </div>

                                </div>
                                <div className="mb-3 row p-1">
                                    <label for="inputCountry" className="col-sm-2 col-form-label">*Country</label>
                                    <div className="col-sm-10">
                                        <select className="form-select" id="inputCountry" onChange={(e) => { countryChange(e); setCountry(e.target.value) }} >
                                            <option value="" selected disabled>---select Country ---</option>
                                            {
                                                //console.log(countries["states"])
                                                countries.map(obj => (
                                                    (obj.is_deleted == false ?
                                                     <option name="country" value={obj.country_name} data-id={obj.country_id}>{obj.country_name}</option>:""
                                                    )
            
                                                    ))
            

                                            }
                                        </select>
                                        {error && country.length == 0 ?
                                            <lable className="error text-danger" >Country is required</lable> : ""
                                            }

                                    </div>
                                </div>
                                <div className="mb-3 row">
                                    <label for="inputZip" className="col-sm-2 col-form-label">*Zip</label>
                                    <div className="col-sm-10">
                                        <input className="form-control" id="inputZip" name="zip" value={zip} />

                                        {error && zip == "" ?
                                            <lable className="error text-danger" >Zip is required</lable> : ""}
                                    </div>

                                </div>
                                <div className="mb-3 row p-1">
                                    <label for="inputContantName" className="col-sm-2 col-form-label">Contact Name</label>
                                    <div className="col-sm-10">
                                        <input className="form-control" id="inputContantEmail" onChange={(e) => setContact_Name(e.target.value)} />
                                    </div>
                                </div>
                                <div className="mb-3 row p-1">
                                    <label for="inputContantEmail" className="col-sm-2 col-form-label">*Contact Email</label>
                                    <div className="col-sm-10">
                                        <input className="form-control" id="inputContantEmail" placeholder='example@gmail.com' onChange={(e) => setContact_Email(e.target.value)} />

                                        {error && contact_email.length == 0 ?
                                            <lable className="error text-danger" >Email is required</lable> : ""}
                                    </div>
                                </div>
                                <div className='mb-3 row '>
                                    <label for="checkActive" className='col-sm-2 col-form-label'>IsActive</label>
                                    {/* <div className="col-sm-10 mx-0 "> */}
                                    <input className="form-check-input m-2" type="checkbox" name="is_active" value={is_active} id="flexCheckDefault" onChange={() => setActive()} />
                                    {/* {error && is_active == false ?
                                        <lable className="error text-danger mx-0" >Is Active required</lable> : ""} */}
                                    
                                </div>
                            </div>
                            <div>
                                <button type="submit" className="btn btn-dark m-3">Save</button>
                                <button type="reset" className="btn btn-dark m-3" onClick={() => resetForm()}>Reset</button>
                                <Link to="/" className="btn btn-dark m-3">Cancel</Link>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default AddCustomer