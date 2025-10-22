# Smart Clinic Management System - Database Schema Design

## 🏥 Database: `clinicdb`

### Tables and Relationships

#### 1. doctor
| Column Name | Data Type | Constraints | Description |
|--------------|------------|--------------|--------------|
| doctor_id | INT | PRIMARY KEY, AUTO_INCREMENT | Unique doctor ID |
| name | VARCHAR(100) | NOT NULL | Doctor's full name |
| specialty | VARCHAR(100) | NOT NULL | Doctor's specialization |
| email | VARCHAR(100) | UNIQUE | Doctor's email |
| phone | VARCHAR(15) |  | Contact number |

#### 2. patient
| Column Name | Data Type | Constraints | Description |
|--------------|------------|--------------|--------------|
| patient_id | INT | PRIMARY KEY, AUTO_INCREMENT | Unique patient ID |
| name | VARCHAR(100) | NOT NULL | Patient full name |
| dob | DATE |  | Date of birth |
| email | VARCHAR(100) | UNIQUE | Email address |
| phone | VARCHAR(15) |  | Contact number |

#### 3. appointment
| Column Name | Data Type | Constraints | Description |
|--------------|------------|--------------|--------------|
| appointment_id | INT | PRIMARY KEY, AUTO_INCREMENT | Appointment ID |
| doctor_id | INT | FOREIGN KEY REFERENCES doctor(doctor_id) | Linked doctor |
| patient_id | INT | FOREIGN KEY REFERENCES patient(patient_id) | Linked patient |
| appointment_date | DATETIME | NOT NULL | Appointment date & time |
| status | VARCHAR(20) | DEFAULT 'Scheduled' | Appointment status |

#### 4. prescription
| Column Name | Data Type | Constraints | Description |
|--------------|------------|--------------|--------------|
| prescription_id | INT | PRIMARY KEY, AUTO_INCREMENT | Prescription ID |
| appointment_id | INT | FOREIGN KEY REFERENCES appointment(appointment_id) | Related appointment |
| details | TEXT |  | Prescription text or notes |
| date_issued | DATE | DEFAULT CURRENT_DATE | Date of issue |

---

### 🔗 Relationships
- One **Doctor** can have many **Appointments**
- One **Patient** can have many **Appointments**
- One **Appointment** may have one **Prescription**

---

### 🧩 ER Diagram (conceptual)
Doctor (1) ────< (N) Appointment (N) >──── (1) Patient
Appointment (1) ────< (1) Prescription
---

### 💾 Database Engine
- MySQL 8.0
- Charset: utf8mb4
- Collation: utf8mb4_general_ci
