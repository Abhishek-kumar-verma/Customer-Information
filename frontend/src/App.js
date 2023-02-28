import logo from './logo.svg';
import './App.css';
import Navbar from './components/navbar/Navbar';
import Home from './components/layout/Home'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter as Router , Routes,Route } from 'react-router-dom';
import AddCustomer from './components/customer/AddCustomer';
import EditCustomer from './components/customer/EditCustomer';
import DeleteCustomer from './components/customer/DeleteCustomer';
import View from './components/customer/View';
import UpdateCustomer from './components/customer/UpdateCustomer';
function App() {
  // var cors = require('cors');
  // app.use(cors())
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home />}/>
          <Route exact path="/addCustomer" element={<AddCustomer />}/>
          <Route exact path="/editCustomer" element={<EditCustomer />}/>
          <Route exact path="/deleteCustomer" element={<DeleteCustomer />}/>
          <Route exact path='/UpdateCustomer/:id' element={<UpdateCustomer />} />
          <Route exact path='/CustomerView/:id' element={<View />} />
        </Routes>

      </Router>
      
    </div>
  );
}

export default App;
