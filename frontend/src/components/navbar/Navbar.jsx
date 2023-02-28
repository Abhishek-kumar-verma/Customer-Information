import React from 'react'
import { Link } from 'react-router-dom'

const Navbar = () => {
    return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                <div className="container-fluid">
                    <a className="navbar-brand" href="#">Assignment-2 </a>
                    {/* <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>  */}
                    <div className="d-grid gap-2 d-md-flex justify-content-md-end">
                        <Link className='btn btn-outline-light ' to='/addCustomer'>Add Customer</Link>
                        <Link className='btn btn-outline-light ' to='/editCustomer'>Edit Customer</Link>
                        <Link className='btn btn-outline-light ' to='/deleteCustomer'>Delete Customer</Link>
                    </div>
                </div>
            </nav>
        </div>
    )
}

export default Navbar