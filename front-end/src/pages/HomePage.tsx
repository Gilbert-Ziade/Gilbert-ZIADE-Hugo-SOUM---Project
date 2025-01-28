import { Button, Typography } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
const HomePage = () => {
    const navigate = useNavigate();
    const {authState} = useAuth();
    const {isAuthenticated, user} = authState;
    return !isAuthenticated ? (
        
        <div style={StyleSheet.container}>
            <Typography variant="h1">Home Page</Typography>
            <div style={StyleSheet.buttonContainer}>
            <Button style={StyleSheet.button}  variant="contained" onClick={() => { navigate('/signin')
            }}>Se connecter</Button>
            <Button style={StyleSheet.button} variant="contained"
            onClick={() => { navigate('/signup')
            }}
            >S'inscrire</Button>
            </div>
        </div>
    ) : (
        <div>
            <Typography variant="h1">Home Page</Typography>

            <h2>Bonjour {user?.username}</h2>
        </div>
    )
};

const StyleSheet = {
    container: {
    },
    buttonContainer: {
        display: "flex",
        justifyContent: "center",
        gap: "10px",
    },
    button: {
        backgroundColor: "#edafb8",
    },
};

export default HomePage;