import { Button, Typography } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { useEffect, useState } from "react";
import OrderDisplayer, { Order } from "../components/OrderDisplayer";
const HomePage = () => {
    const navigate = useNavigate();
    const {authState,} = useAuth();
    const {isAuthenticated, user} = authState;
    const [orders, setOrder] = useState<Order[]>([]);

    const fetchOrder = async () => {
        if(user) {
        try{
            const response = await fetch(`http://myapp.local/orders/api/orders/user/${user.id}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
        }
        }

    );
    if (response.ok) {
        const data = await response.json();
        console.log(data);
        setOrder(data);
    }
    } catch (error) {
        console.error('An error occurred during login:', error);
    };
    }};

    useEffect(() => {
        console.log(user);
        if(user) {
            console.log('fetching orders')
            fetchOrder();
        }


    }, [isAuthenticated,user]);

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

            <OrderDisplayer orders={orders} />

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