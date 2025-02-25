import { useNavigate } from 'react-router-dom';

import { Form, FormField } from "../components";
import { useAuth } from '../contexts/AuthContext';

const SignUp = () => {

    const navigate = useNavigate();
    const { setAuthState } = useAuth();

    const formStructure: FormField[] = [
      { name: 'username', label: 'Username', type: 'text' },
      { name: 'email', label: 'Email', type: 'text' },
      { name: 'password', label: 'Mot de passe', type: 'password' },
      { name: 'phoneNumber', label: 'Numéro de téléphone', type: 'text' },
      { name: 'address', label: 'Adresse', type: 'text' },

    ];
  
        const handleFormSubmit = async (formData: { [key: string]: any }) => {
          try {
            const response = await fetch('http://myapp.local:5000/users/api/users', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json',
              },
              body: JSON.stringify(formData),
            });
            console.log(formData)
            if (response.ok) {
              const userData = await response.json();
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
            <Form formStructure={formStructure} label="S'inscrire" onSubmit={handleFormSubmit} />
        </>
    )
}

export default SignUp;