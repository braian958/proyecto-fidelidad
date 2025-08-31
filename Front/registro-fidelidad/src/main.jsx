import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import ApiService from './apiService'
import Formulario from './registro'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Formulario />
  </StrictMode>,
)
