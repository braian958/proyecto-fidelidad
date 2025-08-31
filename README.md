# 🎯 Proyecto de Fidelidad  

Aplicación para la **gestión de clientes fieles**, donde los usuarios se pueden registrar mediante un formulario y su información es almacenada en una base de datos para realizar un seguimiento de los clientes más leales.  

---

## 📖 Descripción  
Este proyecto es una aplicación de fidelización de clientes que permite:  
- Registrar usuarios desde un **formulario en React**.  
- Seleccionar dinámicamente **países, departamentos y ciudades**.  
- Almacenar la información en una base de datos **PostgreSQL**.  
- Mostrar notificaciones interactivas con **SweetAlert2**.  

---

## 🛠 Tecnologías utilizadas  

### 🔹 Backend  
- **Java Spring Boot** `24.0.1`  

### 🔹 Frontend  
- **React.js** con Node.js  
- **SweetAlert2** (para notificaciones animadas)  

### 🔹 Base de datos  
- **PostgreSQL**  

---

## ⚙️ Instalación  

### 🔹 Requisitos previos  
Asegúrate de tener instalado en tu máquina:  
- [Node.js](https://nodejs.org/) >= 16  
- [Java JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) >= 17  
- [PostgreSQL](https://www.postgresql.org/)  


## 🚀 Uso  

1. Accede al formulario desde la aplicación.  
2. Ingresa los datos de registro: nombres, apellidos, identificación, país, departamento, ciudad, dirección y marca.  
3. El sistema mostrará un mensaje de confirmación con **SweetAlert2**.  
4. Los datos se guardan en la base de datos PostgreSQL.  

---

## 📂 Estructura del Proyecto  

```bash
src
├── components
│   ├── ConsumirApi.jsx       # Lógica para consumir la API 
│   ├── registro.jsx          # Formulario de registro de usuarios ,  # Conexión con el backend
│
├── main.jsx                  # Punto de entrada de React
├── index.css                 # Estilos globales
```

## 👨‍💻 Autor  

- **Tu Nombre** – [GitHub](https://github.com/braian958) 
