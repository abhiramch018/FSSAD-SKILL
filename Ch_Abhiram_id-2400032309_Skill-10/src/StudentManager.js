
import React, { useState } from "react";

function StudentManager(){

const [students, setStudents] = useState([
 {id:1, name:"Rahul", course:"CSE"},
 {id:2, name:"Anita", course:"ECE"},
 {id:3, name:"Kiran", course:"IT"},
 {id:4, name:"Meena", course:"AI"},
 {id:5, name:"Ravi", course:"DS"}
]);

const [newStudent, setNewStudent] = useState({
 id:"",
 name:"",
 course:""
});

const handleChange = (e) => {
 const {name,value} = e.target;
 setNewStudent({...newStudent,[name]:value});
};

const addStudent = () => {
 if(!newStudent.id || !newStudent.name || !newStudent.course){
   alert("Please fill all fields");
   return;
 }

 setStudents([...students,newStudent]);

 setNewStudent({
  id:"",
  name:"",
  course:""
 });
};

const deleteStudent = (id) => {
 setStudents(students.filter(s => s.id != id));
};

return(

<div>

<div className="form">
<input
 type="text"
 placeholder="ID"
 name="id"
 value={newStudent.id}
 onChange={handleChange}
/>

<input
 type="text"
 placeholder="Name"
 name="name"
 value={newStudent.name}
 onChange={handleChange}
/>

<input
 type="text"
 placeholder="Course"
 name="course"
 value={newStudent.course}
 onChange={handleChange}
/>

<button onClick={addStudent}>Add Student</button>

</div>

{students.length === 0 ? (
 <p>No students available</p>
) : (
<table>
<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Course</th>
<th>Action</th>
</tr>
</thead>

<tbody>
{students.map((s,index)=>(
<tr key={index}>
<td>{s.id}</td>
<td>{s.name}</td>
<td>{s.course}</td>
<td>
<button onClick={()=>deleteStudent(s.id)}>Delete</button>
</td>
</tr>
))}
</tbody>

</table>
)}

</div>
);
}

export default StudentManager;
