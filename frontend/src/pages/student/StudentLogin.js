import { useState } from "react";
import { loginStudent } from "../../api/studentService";

export default function StudentLogin() {
  const [data, setData] = useState({ email: "", password: "" });

  const submit = () => {
    loginStudent(data).then(res => alert("Login Success"));
  };

  return (
    <div>
      <h2>Student Login</h2>
      <input placeholder="Email" onChange={e => setData({ ...data, email: e.target.value })} />
      <input placeholder="Password" type="password" onChange={e => setData({ ...data, password: e.target.value })} />
      <button onClick={submit}>Login</button>
    </div>
  );
}
