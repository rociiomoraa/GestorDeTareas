# 📌 Gestor de Tareas en Java

¡Bienvenido/a al **Gestor de Tareas**! 📝🚀 Este es un programa en **Java** que permite gestionar tareas de manera eficiente desde la terminal. Permite **agregar, ver, marcar como completadas, desmarcar y eliminar tareas**, manteniendo la persistencia de datos en un archivo.

## 📜 Características
- ✅ Agregar tareas con **fecha y hora de creación**.
- ✅ Ver tareas **ordenadas** (las completadas aparecen al final).
- ✅ Marcar tareas como completadas ✅.
- ✅ Desmarcar tareas para volverlas a pendientes.
- ✅ Eliminar tareas de la lista.
- ✅ Guardado automático en **tareas.txt** para no perder los datos.

---

## 🔧 Requisitos
- Tener **Java 8** o superior instalado.
- Un editor de código como **IntelliJ IDEA** o **VS Code**.

---

## 🚀 Instalación y Uso
### 1️⃣ Clonar el Repositorio
```bash
git clone https://github.com/tu-usuario/gestor-de-tareas.git
cd gestor-de-tareas
```

### 2️⃣ Compilar el Proyecto
```bash
javac -d bin src/com/gestortareas/Main.java
```

### 3️⃣ Ejecutar el Programa
```bash
java -cp bin com.gestortareas.Main
```

---

## 🖥 Cómo Usarlo
Al ejecutar el programa, verás un menú como este:
```plaintext
--- Gestor de Tareas ---
1. Agregar tarea
2. Ver tareas (ordenadas)
3. Marcar tarea como completada
4. Eliminar tarea
5. Desmarcar tarea completada
6. Salir
Elige una opción:
```
**Opciones disponibles:**
- **1:** Agregar una nueva tarea.
- **2:** Ver la lista de tareas (mostrando primero las pendientes y luego las completadas).
- **3:** Marcar una tarea como completada.
- **4:** Eliminar una tarea.
- **5:** Desmarcar una tarea completada.
- **6:** Salir del programa.

---

## 📂 Estructura del Proyecto
```
/gestor-de-tareas
│── src/com/gestortareas/Main.java   # Código fuente principal
│── tareas.txt                       # Archivo donde se guardan las tareas
│── README.md                         # Este archivo con información del proyecto
```

---

## 📝 Ejemplo de Uso
```
Elige una opción: 1
Escribe una nueva tarea: Comprar leche
Tarea agregada con éxito!

Elige una opción: 2
--- Lista de Tareas ---
1. Comprar leche (Agregada el: 2024-02-05 15:30)

Elige una opción: 3
Elige el número de la tarea que deseas marcar como completada: 1
Tarea marcada como completada.

Elige una opción: 2
--- Lista de Tareas ---
1. ✔ Comprar leche (Agregada el: 2024-02-05 15:30)
```

---

## 🔗 Contribuciones
¡Las contribuciones son bienvenidas! 🎉 Si quieres mejorar el proyecto:
1. Haz un **fork** del repositorio.
2. Crea una **rama** con tus cambios.
3. Haz un **pull request** explicando las mejoras.

---

## 🏆 Autor
- 👤 **Rocío Mora García**  
- 📧 **rocio.mora.garcia02@gmail.com**  
- 🌐 [Mi Perfil de GitHub](https://github.com/rociimoraa)

---

¡Gracias por usar este gestor de tareas! 🚀😊

