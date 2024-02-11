import React, { useState } from 'react';
import axios from 'axios';
const RegisterForm = () => {
    const [formData, setFormData] = useState({
        // UserId:'',
        skills: '',
        wages: '',
        address: '',
        date: ''
    });

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
            const response = await axios.post('http://localhost:7373/a/insert', formData);
            console.log(response.data); // Handle response from server
            // Reset form after successful submission
            setFormData({
                // UserId:'',
                skills: '',
                wages: '',
                address: '',
                date: ''
            });
        } catch (error) {
            console.error('Error:', error);
        }
        //console.log({ skills, wages, address, date });
    };

    return(
        <form onSubmit={handleSubmit}>
            <h2>Requirements Details</h2> 
            {/* <label>
                UserId:
                <input type="number" name="UserId" value={formData.UserId} onChange={handleChange} style={styles.input} required/>
           
            </label> */}
           <label>
            Skills:
            <input type="text" name="skills" value={formData.skills} onChange={handleChange} style={styles.input} required/>
            </label>
           
            <label>
                Wages:
                <input type="text" name="wages" value={formData.wages} onChange={handleChange} style={styles.input} required/>
            </label>
            <label>
                Address:
                <input type="text" name="address" value={formData.address} onChange={handleChange} style={styles.input} required/>
            </label>
             
            
            Date:
            <input type="date" name="date" value={formData.date} onChange={handleChange} style={styles.input}  />
           
            <button type="submit" style={styles.button}>Register</button>
           
        </form>
    );
};
const styles = {
    registerContainer: {
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      height: '100vh',
    },
    registerForm: {
      maxWidth: '200px',
      padding: '20px',
      backgroundColor: '#fff',
      borderRadius: '10px',
      boxShadow: '0 0 1opx rgba(o, o, o, o.1)',
    },
    input: {
      width: 'calc(100% - 20px)',
      padding: '10px',
      marginBottom: '10px',
      border: '1px solid #ccc',
      borderRadius: '5px',
    },
    button: {
      width: '100%',
      padding: '10px',
      backgroundColor: '#007bff',
      color: '#fff',
      border: 'none',
      borderRadius: '5px',
      cursor: 'pointer',
      transition: 'background-color 0.3s ease',
    },
  };
export default RegisterForm;