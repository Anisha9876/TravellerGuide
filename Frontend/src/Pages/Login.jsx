import "./Login.css";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Login() {

  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    email: "",
    password: ""
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
        "http://localhost:8080/auth/login",
        formData
      );

      console.log("Login response:", response.data);

      // Save JWT
      localStorage.setItem("token", response.data);

      alert("Login successful!");

      // Go to Home
      navigate("/");

    } catch (error) {
      console.error("Login error:", error.response?.data || error);
      alert("Login failed!");
    }
  };

  return (
    <div className="login-page">

      <div className="login-box">

        <h1>Welcome Back</h1>
        <p>Login to continue your journey</p>

        <form onSubmit={handleSubmit}>

          <label>Email</label>
          <input
            type="email"
            name="email"
            placeholder="Enter your email"
            value={formData.email}
            onChange={handleChange}
          />

          <label>Password</label>
          <input
            type="password"
            name="password"
            placeholder="Enter your password"
            value={formData.password}
            onChange={handleChange}
          />

          <button type="submit">
            Login
          </button>

        </form>

        <div className="divider">
          <span>or</span>
        </div>

        <button className="google-btn">
          Continue with Google
        </button>

        <p className="register-text">
          Don't have an account?
          <a href="/register"> Register</a>
        </p>

      </div>

    </div>
  );
}

export default Login;