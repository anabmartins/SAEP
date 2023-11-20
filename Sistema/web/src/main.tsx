import React from 'react'
import Login from './screens/Login'
import Manage from './screens/Manage'
import ReactDOM from 'react-dom/client'
import {
  createBrowserRouter,
  RouterProvider
} from 'react-router-dom'

import './index.css'
import Atividade from './screens/Atividade'

const router = createBrowserRouter(
  [
    {
      path: '/',
      element: <Login />
    },
    {
      path: '/manage',
      element: <Manage />
    },
    {
      path: '/atividade',
      element: <Atividade />
    },
  ]
)

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
