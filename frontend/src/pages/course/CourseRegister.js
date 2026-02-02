import { useState } from "react";
import { registerCourse } from "../../api/courseService";

export default function CourseRegister() {
  const [data, setData] = useState({
    courseName: "",
    price: ""
  });

  const submit = () => {
    registerCourse(data)
      .then(() => alert("Course Registered Successfully"))
      .catch(err => alert(err.response?.data?.message || "Error"));
  };

  return (
    <div>
      <h2>Course Register</h2>

      <input
        placeholder="Course Name"
        onChange={e => setData({ ...data, courseName: e.target.value })}
      /><br /><br />

      <input
        placeholder="Price"
        type="number"
        onChange={e => setData({ ...data, price: e.target.value })}
      /><br /><br />

      <button onClick={submit}>Register</button>
    </div>
  );
}
