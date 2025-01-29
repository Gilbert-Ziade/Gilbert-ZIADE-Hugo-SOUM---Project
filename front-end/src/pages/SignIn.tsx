import { useNavigate } from 'react-router-dom';

import { Form, FormField } from "../components";
import { useAuth } from '../contexts/AuthContext';

const SignIn = () => {

    const navigate = useNavigate();
    const { setAuthState } = useAuth();

    const formStructure: FormField[] = [
      { name: 'email', label: 'Email', type: 'text' },
      { name: 'password', label: 'Mot de passe', type: 'password' },

    ];
  
        const handleFormSubmit = async (formData: { [key: string]: any }) => {
          try {
            const response = await fetch('http://localhost:8081/api/users/login', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json',
              },
              body: JSON.stringify(formData),
            });
            console.log(formData)
            if (response.ok) {
              const userData = await response.json();
              console.log(userData);
              setAuthState({
                isAuthenticated: true,
                user: userData,
              });
              localStorage.setItem('user', JSON.stringify(userData));
              navigate('/');
              console.log('Connexion réussie');
            } else {
              console.log('Connexion échouée');
            }
          } catch (error) {
            console.error('An error occurred during login:', error);
          }
        };
    return (
        <>
            <Form formStructure={formStructure} label="Se connecter" onSubmit={handleFormSubmit} />
        </>
    )
}

export default SignIn;