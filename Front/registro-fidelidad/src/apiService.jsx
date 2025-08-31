
const BASE_URL = "http://localhost:8080/api";


const ApiRequest = async (endpoint, options = {}) => {
  const url = `${BASE_URL}${endpoint}`;
  const config = {
    headers: {
      "Content-Type": "application/json",
      ...options.headers,
    },
    ...options,
  };

  try {
    const response = await fetch(url, config);
    if (!response.ok) {
      throw new Error(`Error ${response.status}: ${response.statusText}`);
    }
    return await response.json();
  } catch (error) {
    console.log(`Error en petición a ${endpoint}:`, error);
    throw error;
  }
};


const ApiService = {


  obtenerPaises: async () => {
  const response = await ApiRequest("/pais");
  return response.data || []; 
},



  obtenerDepartamentosPorPais: async (paisId) => {
    const pais = await ApiRequest(`/pais/${paisId}`);
    return pais.departamentos || [];
  },

  obtenerCiudadesPorDepartamento: async (departamentoId) => {
    const departamento = await ApiRequest(`/departamento/${departamentoId}`);
    return departamento.ciudades || [];
  },


  registrarCliente: (clienteData) =>
    ApiRequest("/cliente", {
      method: "POST",
      body: JSON.stringify(clienteData),
    }),


  crearPais: (paisData) =>
    ApiRequest("/pais", {
      method: "POST",
      body: JSON.stringify(paisData),
    }),


  crearDepartamento: (departamentoData) =>
    ApiRequest("/departamento", {
      method: "POST",
      body: JSON.stringify(departamentoData),
    }),


  crearCiudad: (ciudadData) =>
    ApiRequest("/ciudad", {
      method: "POST",
      body: JSON.stringify(ciudadData),
    }),

};

export default ApiService;
