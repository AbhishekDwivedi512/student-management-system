import { useState } from "react";
import { registerStudent } from "../../api/studentService";

export default function StudentRegister() {
  const [data, setData] = useState({ name: "", email: "", password: "" });

  const submit = () => {
    registerStudent(data).then(() => alert("Student Registered"));
  };

  return (
    <div>
      <h2>Student Register</h2>
      <input placeholder="Name" onChange={e => setData({ ...data, name: e.target.value })} />
      <input placeholder="Email" onChange={e => setData({ ...data, email: e.target.value })} />
      <input placeholder="Password" type="password" onChange={e => setData({ ...data, password: e.target.value })} />
      <button onClick={submit}>Register</button>
    </div>
  );
}
