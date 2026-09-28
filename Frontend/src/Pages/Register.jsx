import { useState } from "react";
import axios from "axios";
import "./Register.css";

function Register() {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    phone: "",
    password: "",
    gender: ""
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post(
        "http://localhost:8080/auth/register",
        formData
      );

      alert("Registration successful!");
      console.log(response.data);

    } catch (error) {
  console.error("Registration error:", error);
  console.error("Backend response:", error.response?.data);

  alert(
    error.response?.data?.message ||
    error.response?.data ||
    "Registration failed"
  );
}
  };

  return (
    <div className="register-page">
      <div className="register-box">

        <h1>Create Account</h1>
        <p>Start your journey with TravellerGuide</p>

        <form onSubmit={handleSubmit}>

          <label>Name</label>
          <input
            type="text"
            name="name"
            placeholder="Enter your name"
            value={formData.name}
            onChange={handleChange}
          />

          <label>Email</label>
          <input
            type="email"
            name="email"
            placeholder="Enter your email"
            value={formData.email}
            onChange={handleChange}
          />

          <label>Phone</label>
          <input
            type="tel"
            name="phone"
            placeholder="Enter your phone number"
            value={formData.phone}
            onChange={handleChange}
          />

          <label>Password</label>
          <input
            type="password"
            name="password"
            placeholder="Create a password"
            value={formData.password}
            onChange={handleChange}
          />
          <label>Gender</label>
        <select
          name="gender"
          value={formData.gender}
          onChange={handleChange}
        >
          <option value="">Select gender</option>
          <option value="MALE">Male</option>
          <option value="FEMALE">Female</option>
          <option value="OTHER">Other</option>
        </select>
        

          <button type="submit">Create Account</button>

        </form>

        <div className="divider">
          <span>or</span>
        </div>

        <button className="google-btn">
          Continue with Google
        </button>

        <p className="login-text">
          Already have an account?
          <a href="/login"> Login</a>
        </p>

      </div>
    </div>
  );
}

export default Register;