import ApiService from "./apiService";
import { useState, useEffect } from "react";
import Swal from "sweetalert2";

const paisesRespaldo = [
  { id: 1, nombre: "Colombia" },
  { id: 2, nombre: "EEUU" },
  { id: 3, nombre: "Ecuador" },
  { id: 4, nombre: "Peru" },
  { id: 5, nombre: "Panama" }
];

const departamentosRespaldo = {
  1: [ 
    { id: 6, nombre: "Antioquia" },
    { id: 7, nombre: "Amazonas" },
    { id: 16, nombre: "Cundinamarca" },
    { id: 17, nombre: "Valle del Cauca" }
  ],
  2: [ 
    { id: 8, nombre: "California" },
    { id: 9, nombre: "Texas" },
    { id: 18, nombre: "Florida" }
  ],
  3: [ 
    { id: 10, nombre: "Guayas" },
    { id: 11, nombre: "Pichincha" }
  ],
  4: [ 
    { id: 12, nombre: "Lima" },
    { id: 13, nombre: "Cusco" }
  ],
  5: [ 
    { id: 14, nombre: "Provincia de Panamá" },
    { id: 15, nombre: "Provincia de Colón" }
  ]
};

const ciudadesRespaldo = {
  6: [{ id: 3, nombre: "Medellín" }, { id: 19, nombre: "Bello" }, { id: 20, nombre: "Itagüí" }], 
  7: [{ id: 5, nombre: "Leticia" }], 
  8: [{ id: 6, nombre: "Los Ángeles" }, { id: 21, nombre: "San Francisco" }],
  9: [{ id: 7, nombre: "Houston" }, { id: 22, nombre: "Dallas" }], 
  10: [{ id: 8, nombre: "Guayaquil" }],
  11: [{ id: 9, nombre: "Quito" }], 
  12: [{ id: 10, nombre: "Lima" }], 
  13: [{ id: 11, nombre: "Cusco" }], 
  14: [{ id: 12, nombre: "Ciudad de Panamá" }],
  15: [{ id: 13, nombre: "Colón" }], 
  16: [{ id: 23, nombre: "Bogotá" }, { id: 24, nombre: "Soacha" }],
  17: [{ id: 25, nombre: "Cali" }, { id: 26, nombre: "Palmira" }], 
  18: [{ id: 27, nombre: "Miami" }, { id: 28, nombre: "Orlando" }] 
};

function Formulario() {
  const [formData, setFormData] = useState({
    id: "",
    nombres: "",
    apellidos: "",
    pais: "",
    ciudad: "",
    departamento: "",
    direccion: "",
    tipoIdentificacion: "", 
    numeroIdentificacion: "", 
    fechaNacimiento: "",
    marca: "",
  });

  const [paises, setPaises] = useState([]);
  const [departamentos, setDepartamentos] = useState([]);
  const [ciudades, setCiudades] = useState([]);

  useEffect(() => {
    const cargarDatosIniciales = async () => {
      try {
        const paisesData = await ApiService.obtenerPaises();
        setPaises(paisesData && paisesData.length > 0 ? paisesData : paisesRespaldo);
      } catch (error) {
        console.error("Error al cargar los datos, usando datos de respaldo", error);
        setPaises(paisesRespaldo);
      }
    };

    cargarDatosIniciales();
  }, []);

  const handleChange = async (e) => {
    const { name, value } = e.target;
    
    console.log(`Campo cambiado: ${name} = ${value}`); 
    
    setFormData({
      ...formData,
      [name]: value,
    });

  
    if (name === "pais") {
      console.log(`País seleccionado: ${value}`); 
      
     
      setFormData(prev => ({
        ...prev,
        [name]: value,
        departamento: "",
        ciudad: ""
      }));
      
      setCiudades([]);
      
      if (value) {
        try {
          console.log(`Intentando cargar departamentos para país: ${value}`); 
          const departamentosData = await ApiService.obtenerDepartamentosPorPais(value);
          console.log('Departamentos de API:', departamentosData);
          
          if (departamentosData && departamentosData.length > 0) {
            setDepartamentos(departamentosData);
          } else {
            console.log('API devolvió vacío, usando respaldo'); 
            const respaldo = departamentosRespaldo[parseInt(value)] || [];
            console.log('Departamentos de respaldo:', respaldo);
            setDepartamentos(respaldo);
          }
        } catch (error) {
          console.error("Error al cargar departamentos:", error);
          const respaldo = departamentosRespaldo[parseInt(value)] || [];
          console.log('Usando respaldo por error:', respaldo);
          setDepartamentos(respaldo);
        }
      } else {
        setDepartamentos([]);
      }
    }

    if (name === "departamento") {
      console.log(`Departamento seleccionado: ${value}`); 
      
      
      setFormData(prev => ({
        ...prev,
        [name]: value,
        ciudad: ""
      }));
      
      if (value) {
        try {
          console.log(`Intentando cargar ciudades para departamento: ${value}`); 
          const ciudadesData = await ApiService.obtenerCiudadesPorDepartamento(value);
          console.log('Ciudades de API:', ciudadesData);
          if (ciudadesData && ciudadesData.length > 0) {
            setCiudades(ciudadesData);
          } else {
            console.log('API devolvió vacío, usando respaldo');
            const respaldo = ciudadesRespaldo[parseInt(value)] || [];
            console.log('Ciudades de respaldo:', respaldo);
            setCiudades(respaldo);
          }
        } catch (error) {
          console.error("Error al cargar ciudades:", error);
          const respaldo = ciudadesRespaldo[parseInt(value)] || [];
          console.log('Usando respaldo por error:', respaldo);
          setCiudades(respaldo);
        }
      } else {
        setCiudades([]);
      }
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const dataToSend = {
      nombres: formData.nombres,
      apellidos: formData.apellidos,
      direccion: formData.direccion,
      numeroIdentificacion: formData.numeroIdentificacion,
      fechaNacimiento: formData.fechaNacimiento,
      tipoIdentificacion: { id: parseInt(formData.tipoIdentificacion) },
      departamento: { id: parseInt(formData.departamento) },
      pais: { id: parseInt(formData.pais) },
      ciudad: { id: parseInt(formData.ciudad) },
      marca: { id: parseInt(formData.marca) },
    };
         
    try {
      await ApiService.registrarCliente(dataToSend);
      Swal.fire({
        title: "Usuario registrado",
        icon: "success",
        draggable: true
      });
     
      setFormData({
        id: "",
        nombres: "",
        apellidos: "",
        pais: "",
        ciudad: "",
        departamento: "",
        direccion: "",
        tipoIdentificacion: "",
        numeroIdentificacion: "",
        fechaNacimiento: "",
        marca: "",
      });
      setDepartamentos([]);
      setCiudades([]);
    } catch  {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Error al registrar el usuario",
        footer: '<a href="#">Why do I have this issue?</a>'
      });
    }
  };

  return (
    <div className="con-p">
      <h2>Registrate</h2>
      <h3>Programa de fidelidad</h3>
      <hr />

      <form onSubmit={handleSubmit}>
        <input
          className="nombres"
          type="text"
          id="nombres"
          name="nombres"
          value={formData.nombres}
          onChange={handleChange}
          required
          placeholder="Nombres"
        />
        <input
          className="apellidos"
          type="text"
          id="apellidos"
          name="apellidos"
          value={formData.apellidos}
          onChange={handleChange}
          required
          placeholder="Apellidos"
        />
        <select
          className="tipoIdentificacion"
          id="tipoIdentificacion"
          name="tipoIdentificacion"
          required
          value={formData.tipoIdentificacion}
          onChange={handleChange}
        >
          <option value="" disabled>
            Tipo de identificación
          </option>
          <option value="1">CC</option>
          <option value="2">TI</option>
          <option value="3">CE</option>
          <option value="4">PA</option>
        </select>
        <input
          className="numeroIdentificacion"
          type="text"
          id="numeroIdentificacion"
          name="numeroIdentificacion"
          value={formData.numeroIdentificacion}
          onChange={handleChange}
          required
          placeholder="Número de identificación"
        />
        <input
          className="fechaNacimiento"
          type="date"
          id="fechaNacimiento"
          name="fechaNacimiento"
          value={formData.fechaNacimiento}
          onChange={handleChange}
          required
        />
        
        {/* SELECTOR DE PAÍS */}
        <select
          className="pais"
          id="pais"
          name="pais"
          required
          value={formData.pais}
          onChange={handleChange}
        >
          <option value="" disabled>
            Seleccionar país
          </option>
          {paises.map((pais) => (
            <option key={pais.id} value={pais.id}>
              {pais.nombre}
            </option>
          ))}
        </select>
        
        {/* SELECTOR DE DEPARTAMENTO */}
        <select
          className="departamento"
          id="departamento"
          name="departamento"
          required
          value={formData.departamento}
          onChange={handleChange}
          disabled={!formData.pais}
        >
          <option value="" disabled>
            {formData.pais ? "Seleccionar departamento" : "Primero selecciona un país"}
          </option>
          {departamentos.map((dept) => (
            <option key={dept.id} value={dept.id}>
              {dept.nombre}
            </option>
          ))}
        </select>
        
        {/* SELECTOR DE CIUDAD */}
        <select
          className="ciudad"
          id="ciudad"
          name="ciudad"
          required
          value={formData.ciudad}
          onChange={handleChange}
          disabled={!formData.departamento}
        >
          <option value="" disabled>
            {formData.departamento ? "Seleccionar ciudad" : "Primero selecciona un departamento"}
          </option>
          {ciudades.map((ciudad) => (
            <option key={ciudad.id} value={ciudad.id}>
              {ciudad.nombre}
            </option>
          ))}
        </select>
        
        <input
          className="direccion"
          type="text"
          id="direccion"
          name="direccion"
          value={formData.direccion}
          onChange={handleChange}
          required
          placeholder="Dirección"
        />
        <select
          className="marca"
          id="marca"
          name="marca"
          required
          value={formData.marca}
          onChange={handleChange}
        >
          <option value="" disabled>
            Seleccionar marca
          </option>
          <option value="1">Americanino</option>
          <option value="2">American Eagle</option>
          <option value="3">Chevignon</option>
          <option value="4">Esprit</option>
          <option value="5">Naf Naf</option>
          <option value="6">Rifle</option>
        </select>
        <button className="boton" type="submit">
          Registrarse
        </button>
      </form>
    </div>
  );   
}

export default Formulario;