FSAD Skill-13 Deployment

Steps:
1. Go to frontend:
   npm install
   npm run build

2. Copy contents of frontend/build into:
   backend/src/main/resources/static/

3. Build backend:
   mvn clean package

4. Run:
   java -jar target/demo-0.0.1-SNAPSHOT.jar

5. Open:
   http://localhost:8080
