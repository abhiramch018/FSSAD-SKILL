import React, { useEffect, useState } from "react";
import axios from "axios";

function StudentList() {
  const [students, setStudents] = useState([]);

  const fetchData = () => {
    axios.get("http://localhost:8080/students")
      .then(res => setStudents(res.data));
  };

  useEffect(() => { fetchData(); }, []);

  const deleteStudent = (id) => {
    axios.delete(`http://localhost:8080/students/${id}`)
      .then(() => fetchData());
  };

  return (
    <div className="student-container">
      <h2>Students</h2>
      {students.map(s => (
        <div className="student-card" key={s.id}>
          <span>{s.name} - {s.email} - {s.course}</span>
          <button className="delete-btn" onClick={() => deleteStudent(s.id)}>
            Delete
          </button>
        </div>
      ))}
    </div>
  );
}
export default StudentList;