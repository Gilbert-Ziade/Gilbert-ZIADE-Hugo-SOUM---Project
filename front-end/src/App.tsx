
import './App.css'
import { AuthProvider } from './contexts/AuthContext';
import { RouterProvider, createBrowserRouter, } from 'react-router-dom';
import SignUp from './pages/SignUp'


function App() {

  const router = createBrowserRouter([
    {
      path: "/",
      children: [
        { path: "/", element: <SignUp /> },

      ],
    },
  ]);

  return (
    <AuthProvider>
      <RouterProvider router={router} />
    </AuthProvider>
  );
}

export default App
