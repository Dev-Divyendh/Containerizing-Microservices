# 🧾 Student Survey Microservice

This project implements a full-stack backend microservice for managing student surveys at a university. Built using **Spring Boot** and **MySQL (Amazon RDS)**, the service is containerized with **Docker**, deployed to **Kubernetes on AWS EC2**, and orchestrated via a **Jenkins CI/CD pipeline**. The microservice enables full **CRUD** operations on survey data and is tested using **Postman**.

---

## 👥 Group Members

- **Dev Divyendh Dhinakaran** (G01450299)
- **Tejaswi Samineni** (G01460925)

---

## ⚙️ Technologies Used

- Java 17 + Spring Boot
- MySQL (Amazon RDS)
- JPA + Hibernate
- Docker
- Docker Hub
- Kubernetes (k3s on AWS EC2)
- Jenkins CI/CD Pipeline
- Postman
- GitHub

---

## 📌 Features

- REST APIs to Create, Read, Update, and Delete student survey records
- Fields captured:
  - Name, Address, Email, Phone, Date of Survey
  - Preferences (campus, dorms, sports, etc.)
  - Referral source (friends, TV, internet, etc.)
  - Recommendation Likelihood
- Dockerized Spring Boot microservice
- Kubernetes manifests for scalable deployment
- CI/CD integration using Jenkins + GitHub

---

## 🛠️ Project Structure

```
student-survey-microservice/
├── src/
│   └── main/java/com/surveyapp/...
│   └── resources/application.properties
├── Dockerfile
├── Jenkinsfile
├── k8s-config/
│   ├── deployment.yaml
│   └── service.yaml
├── README.md
├── pom.xml
└── docs/
    ├── setup-guide.pdf
    └── demo_screenshots/
```

---

## 🚀 Getting Started

### 1. Clone the Repo

```bash
git clone https://github.com/Dev-Divyendh/Containerizing-Microservices.git
cd Containerizing-Microservices
```

### 2. Build the App

```bash
mvn clean install
```

### 3. Dockerize and Push to Docker Hub

```bash
docker build -t devdivyendh10/survey-service:latest .
docker push devdivyendh10/survey-service:latest
```

---

## 🧪 Postman API Testing (Local)

| Method | Endpoint                       | Description            |
|--------|--------------------------------|------------------------|
| POST   | `/hw3/surveys`                 | Create new survey      |
| GET    | `/hw3/surveys`                 | List all surveys       |
| GET    | `/hw3/surveys/{id}`            | Retrieve survey by ID  |
| PUT    | `/hw3/surveys/{id}`            | Update survey by ID    |
| DELETE | `/hw3/surveys/{id}`            | Delete survey by ID    |

---

## 🌐 Amazon RDS Setup

- **Database Engine:** MySQL (Free Tier)
- **Username:** admin
- **Connection:** MySQL Workbench with public access enabled
- **Security Group:** Inbound rules for EC2 traffic

---

## ☁️ Kubernetes on AWS EC2 (k3s)

### 1. EC2 Instance Setup

- Type: `t3.medium` | OS: Ubuntu 24.04 LTS
- Ports Opened: 22, 80, 443
- SSH Key Pair used for access

### 2. Install Docker

```bash
sudo apt update && sudo apt upgrade -y
sudo apt install -y docker.io
sudo systemctl enable docker
sudo systemctl start docker
```

### 3. Install k3s

```bash
curl -sfL https://get.k3s.io | sh -
```

### 4. Configure kubectl

```bash
sudo cp /etc/rancher/k3s/k3s.yaml ~/.kube/config
sudo chown $(id -u):$(id -g) ~/.kube/config
```

### 5. Deploy App

```bash
kubectl apply -f k8s-config/deployment.yaml
kubectl apply -f k8s-config/service.yaml
```

---

## 🔁 CI/CD Pipeline with Jenkins

1. **Trigger:** GitHub webhook on every commit
2. **Stages:**
   - **Checkout:** Clone latest repo
   - **Build:** Compile and package Spring Boot app
   - **Dockerize:** Build and push Docker image to Docker Hub
   - **Deploy:** Apply Kubernetes manifests using `kubectl`

---

## 🔗 Live Demo

- **Kubernetes Access:**  
  [http://18.217.11.212:32517/hw3/surveys](http://18.217.11.212:32517/hw3/surveys)

- **GitHub Repo:**  
  [https://github.com/Dev-Divyendh/Containerizing-Microservices](https://github.com/Dev-Divyendh/Containerizing-Microservices)

---

## 📸 Screenshots & Demo

📁 Available in `docs/demo_screenshots/`  
📽️ Demo Video: *[Add your video link here]*

---

## 📚 References & Tools

1. [Amazon EC2](https://aws.amazon.com/ec2)
2. [Amazon RDS](https://aws.amazon.com/rds)
3. [Spring Boot](https://spring.io/projects/spring-boot)
4. [MySQL Workbench](https://www.mysql.com/products/workbench/)
5. [Docker](https://www.docker.com/)
6. [Docker Hub](https://hub.docker.com/)
7. [Kubernetes](https://kubernetes.io/)
8. [Jenkins](https://www.jenkins.io/)
9. [Postman](https://www.postman.com/)
10. [GitHub](https://github.com/)

---

## 👨‍💻 Authors

- Dev Divyendh Dhinakaran — [@Dev-Divyendh](https://github.com/Dev-Divyendh)  
- Tejaswi Samineni
