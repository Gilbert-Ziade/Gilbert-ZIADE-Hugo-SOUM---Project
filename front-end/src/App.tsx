
import './App.css'
import { AuthProvider } from './contexts/AuthContext';
import { RouterProvider, createBrowserRouter, } from 'react-router-dom';
import SignUp from './pages/SignUp'
import HomePage from './pages/HomePage';
import SignIn from './pages/SignIn';
import { ThemeProvider } from '@emotion/react';
import theme from './theme';


function App() {

  const router = createBrowserRouter([
    {
      path: "/",
      children: [
        { path: "/", element: <HomePage /> },

      ],
    },
    {
      path: "/signup",
      element: <SignUp />,
    },
    {
      path: "/signin",
      element: <SignIn />,
    }
  ]);

  return (
    <ThemeProvider theme={theme}>

    <AuthProvider>
      <RouterProvider router={router} />
    </AuthProvider>
    </ThemeProvider>

  );
}

export default App
