<h1>🏥 Hospital Management System (JDBC Backend)</h1>

<p>
A <strong>console-based Hospital Management System</strong> developed using
<strong>Core Java, JDBC, and MySQL</strong>.  
This project focuses on backend fundamentals such as
<strong>entity separation, database interaction, and business validation logic</strong>.
</p>

<hr>

<h2>🚀 Features</h2>
<ul>
  <li>Manages <strong>3 core entities</strong>: Patient, Doctor, and Appointment</li>
  <li>Implements secure <strong>CRUD operations</strong> using JDBC and PreparedStatement</li>
  <li>Validates patient and doctor existence before appointment booking</li>
  <li>Prevents <strong>conflicting doctor appointments</strong> using date-based availability checks</li>
  <li>Ensures backend <strong>data integrity</strong> before database insertion</li>
</ul>

<hr>

<h2>🛠️ Tech Stack</h2>
<ul>
  <li><strong>Language:</strong> Java</li>
  <li><strong>Backend:</strong> JDBC</li>
  <li><strong>Database:</strong> MySQL</li>
  <li><strong>Concepts:</strong> OOP, Relational Databases, PreparedStatement, Backend Validation</li>
</ul>

<hr>

<h2>🧩 Project Structure</h2>
<pre>
HospitalManagementSystem/
│
├── HospitalManagement.java   // Main application & menu-driven flow
├── Patients.java             // Patient CRUD operations
├── Doctors.java              // Doctor CRUD operations
├── Appointments.java         // Appointment booking & validation logic
</pre>

<hr>

<h2>⚙️ How It Works</h2>
<ol>
  <li>Add and view patients and doctors.</li>
  <li>While booking an appointment:
    <ul>
      <li>Patient existence is verified</li>
      <li>Doctor existence is verified</li>
      <li>Doctor availability is checked for the selected date</li>
    </ul>
  </li>
  <li>The appointment is booked only if <strong>all validations pass</strong>.</li>
</ol>

<hr>

<h2>📊 Database Schema Overview</h2>
<ul>
  <li><strong>patients</strong> – stores patient details</li>
  <li><strong>doctors</strong> – stores doctor details</li>
  <li><strong>appointments</strong> – maps patients to doctors with appointment dates</li>
</ul>
<p>
Relational integrity is maintained using foreign keys.
</p>

<hr>

<h2>🧠 Key Learnings</h2>
<ul>
  <li>Hands-on experience with low-level database interaction using JDBC</li>
  <li>Importance of backend validation before data persistence</li>
  <li>Understanding why ORM frameworks like Hibernate/JPA reduce boilerplate code</li>
  <li>Designing backend logic adaptable to Spring Boot architecture</li>
</ul>

<hr>

<h2>🔮 Future Enhancements</h2>
<ul>
  <li>Migrate JDBC logic to Hibernate / JPA</li>
  <li>Convert application into Spring Boot REST APIs</li>
  <li>Add authentication and role-based access</li>
  <li>Integrate frontend using Angular or React</li>
</ul>

<hr>

<p>
<strong>Note:</strong>  
This project was built to strengthen backend fundamentals and understand how
enterprise applications enforce business rules before database persistence.
</p>

