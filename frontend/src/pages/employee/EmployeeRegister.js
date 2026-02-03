import { useState } from "react";
import { registerEmployee } from "../../api/employeeService";

export default function EmployeeRegister() {
  const [data, setData] = useState({
    name: "",
    email: "",
    password: ""
  });

  const submit = () => {
    registerEmployee(data)
      .then(() => alert("Employee Registered Successfully"))
      .catch(err => alert(err.response?.data?.message || "Error"));
  };

  return (
    <div>
      <h2>Employee Register</h2>

      <input
        placeholder="Name"
        onChange={e => setData({ ...data, name: e.target.value })}
      /><br /><br />

      <input
        placeholder="Email"
        onChange={e => setData({ ...data, email: e.target.value })}
      /><br /><br />

      <input
              placeholder="Phone"
              onChange={e => setData({ ...data, phone: e.target.value })}
      /><br /><br />

      <input
              placeholder="Role"
              onChange={e => setData({ ...data, role: e.target.value })}
      /><br /><br />

      <input
              placeholder="DateOfBirth"
              onChange={e => setData({ ...data, dateOfBirth: e.target.value })}
      /><br /><br />

      <input
        type="password"
        placeholder="Password"
        onChange={e => setData({ ...data, password: e.target.value })}
      /><br /><br />

      <button onClick={submit}>Register</button>
    </div>
  );
}
