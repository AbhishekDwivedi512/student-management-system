import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

import StudentRegister from "./pages/student/StudentRegister";
import StudentLogin from "./pages/student/StudentLogin";
import StudentList from "./pages/student/StudentList";

import EmployeeRegister from "./pages/employee/EmployeeRegister";
import EmployeeLogin from "./pages/employee/EmployeeLogin";

import CourseRegister from "./pages/course/CourseRegister";
import CoursePriceUpdate from "./pages/course/CoursePriceUpdate";

function App() {
  return (
    <BrowserRouter>
      <nav style={{ padding: 10 }}>
        <Link to="/student/register">Student Register</Link> |{" "}
        <Link to="/student/login">Student Login</Link> |{" "}
        <Link to="/students">Students</Link> |{" "}
        <Link to="/employee/register">Employee Register</Link> |{" "}
        <Link to="/employee/login">Employee Login</Link> |{" "}
        <Link to="/course/register">Course Register</Link>
      </nav>

      <Routes>
        <Route path="/student/register" element={<StudentRegister />} />
        <Route path="/student/login" element={<StudentLogin />} />
        <Route path="/students" element={<StudentList />} />

        <Route path="/employee/register" element={<EmployeeRegister />} />
        <Route path="/employee/login" element={<EmployeeLogin />} />

        <Route path="/course/register" element={<CourseRegister />} />
        <Route path="/course/update-price" element={<CoursePriceUpdate />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
