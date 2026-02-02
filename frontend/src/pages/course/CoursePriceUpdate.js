import { useState } from "react";
import { updateCoursePrice } from "../../api/courseService";

export default function CoursePriceUpdate() {
  const [courseId, setCourseId] = useState("");
  const [price, setPrice] = useState("");

  const submit = () => {
    updateCoursePrice(courseId, { price })
      .then(() => alert("Course Price Updated"))
      .catch(err => alert("Update Failed"));
  };

  return (
    <div>
      <h2>Update Course Price</h2>

      <input
        placeholder="Course ID"
        onChange={e => setCourseId(e.target.value)}
      /><br /><br />

      <input
        placeholder="New Price"
        type="number"
        onChange={e => setPrice(e.target.value)}
      /><br /><br />

      <button onClick={submit}>Update Price</button>
    </div>
  );
}
