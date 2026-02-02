import { useEffect, useState } from "react";
import { getAllStudents, deleteStudent } from "../../api/studentService";

export default function StudentList() {
  const [students, setStudents] = useState([]);

  const load = () => {
    getAllStudents().then(res => setStudents(res.data));
  };

  useEffect(() => { load(); }, []);

  return (
    <div>
      <h2>All Students</h2>
      {students.map(s => (
        <div key={s.id}>
          {s.name} - {s.email}
          <button onClick={() => deleteStudent(s.id).then(load)}>Delete</button>
        </div>
      ))}
    </div>
  );
}
