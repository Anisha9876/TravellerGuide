
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./Pages/Home";
import Explore from "./Pages/Explore";
import News from "./Pages/News";
import Login from "./Pages/Login";
import Register from "./Pages/Register";
import TripDetails from "./Pages/TripDetails";
function App() {
  return (
    <BrowserRouter>
      <Routes>

        <Route path="/" element={<Home />} />

        <Route path="/explore" element={<Explore />} />

        <Route path="/news" element={<News />} />

        <Route path="/login" element={<Login />} />

        <Route path="/register" element={<Register />} />

        <Route path="/trip-details" element={<TripDetails />} />

        <Route path="/trip-details/:destination" element={<TripDetails />} />

      </Routes>
    </BrowserRouter>
  );
}

export default App;

