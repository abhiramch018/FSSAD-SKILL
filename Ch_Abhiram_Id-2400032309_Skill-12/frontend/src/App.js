import React from "react";
import "./App.css";
import StudentList from "./components/StudentList";
import AddStudent from "./components/AddStudent";

function App() {
  return (
    <div>
      <h1>Student Management</h1>
      <AddStudent />
      <StudentList />
    </div>
  );
}
export default App;