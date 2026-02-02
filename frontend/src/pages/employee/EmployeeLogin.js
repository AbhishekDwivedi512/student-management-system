import { useState } from "react";
import { loginEmployee } from "../../api/employeeService";

export default function EmployeeLogin() {
  const [data, setData] = useState({
    email: "",
    password: ""
  });

  const submit = () => {
    loginEmployee(data)
      .then(() => alert("Employee Login Successful"))
      .catch(err => alert("Invalid Credentials"));
  };

  return (
    <div>
      <h2>Employee Login</h2>

      <input
        placeholder="Email"
        onChange={e => setData({ ...data, email: e.target.value })}
      /><br /><br />

      <input
        type="password"
        placeholder="Password"
        onChange={e => setData({ ...data, password: e.target.value })}
      /><br /><br />

      <button onClick={submit}>Login</button>
    </div>
  );
}
