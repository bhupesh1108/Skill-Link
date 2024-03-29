import React, { useEffect, useState } from "react";
import Image from "../assets/image3.jpg";
import Logo from "../assets/logo.png";
import GoogleSvg from "../assets/icons8-google.svg";
import { FaEye } from "react-icons/fa6";
import { FaEyeSlash } from "react-icons/fa6";

import "./LoginForm.css";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const ServiceRegistration = () => {
  const [ showPassword, setShowPassword ] = useState(false);
    const navigate=useNavigate();
  const [formData, setFormData] = useState({
    namefirst: '',
    namelast: '',
    username: '',
    password: '',
    phonenumber: '',
    skills:'',
    wages:'',
    address: ''
});
const [message, setMessage] = useState('');


const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
        ...prevState,
        [name]: value
    }));
};

const handleSubmit = async (e) => {
    e.preventDefault();
    try {
        const response = await axios.post('http://localhost:7373/serviceprovider/register', formData).then((response) => {
            const result = response.data
          //   const status = response.status
              
            //   console.log(userId)
           

            if (response.status===200){
                // toast.warning("success")
                 
                  alert("success")
                navigate("/serviceprovider")
            }else{
                alert("Wrong Credential")
                // toast.warning("wrong")
                navigate("/ServiceProviderregister")
            }
        
           }   )
        
        
        // setMessage(response.data); // Set the message received from the server
    } catch (error) {
        console.error('Error:', error);
        setMessage('An error occurred. Please try again later.'); // Set a generic error message
    }
};
  return (
    <div className="login-main" >
       <div className="login-left">
      
      <div>
       
       <h2>Earn More with</h2>
       <br/>
      <h2> Skill🔗Link</h2>
    <br></br>
      <img src={Image} alt="" />
      </div>
       
       
      </div>
      <div className="login-right">
        <div className="login-right-container">
          <div className="login-logo">
            {/* <img src={Logo} alt="" /> */}
          </div>
          <div className="login-center">
            
            <p>Please enter your details</p>
        
            <form onSubmit={handleSubmit}>
             
              <input type="text" placeholder="Namefirst" name="namefirst" value={formData.namefirst} onChange={handleChange}/>
              <input type="text" placeholder="Namelast" name="namelast" value={formData.namelast} onChange={handleChange}/>
              <input type="text" placeholder="Username" name="username" value={formData.username} onChange={handleChange}/>
              <div className="pass-input-div">
                <input type={showPassword ? "text" : "password"} placeholder="Password" name="password" value={formData.password} onChange={handleChange}/>
                {showPassword ? <FaEyeSlash onClick={() => {setShowPassword(!showPassword)}} /> : <FaEye onClick={() => {setShowPassword(!showPassword)}} />}
                
              </div>
              {/* <input type="password" placeholder="Password" name="password" value={formData.password} onChange={handleChange}/> */}
              <input type="text" placeholder="Phonenumber" name="phonenumber" value={formData.phonenumber} onChange={handleChange}/>
              <input type="text" placeholder="Skills" name="skills" value={formData.skills} onChange={handleChange}/>
              <input type="text" placeholder="Wages" name="wages" value={formData.wages} onChange={handleChange}/>
              <input type="text" placeholder="Address" name="address" value={formData.address} onChange={handleChange}/>
              

              <div className="login-center-options">
               
              </div>
              <div className="login-center-buttons">
                <button type="submit">Sign Up</button>
               
              </div>
            </form>
          </div>

       =
        </div>
      </div>
    
    </div>
  );
};

export default ServiceRegistration;
