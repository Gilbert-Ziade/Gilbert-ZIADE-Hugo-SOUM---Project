import { createTheme } from '@mui/material/styles';

const theme = createTheme({
  palette: {
    primary: {
      main: '#edafb8', // Your primary color
      contrastText: '#ffffff', // Text color on primary
    },
    secondary: {
      main: '#edafb8', // Your secondary color
      light: '#d05ce3',
      dark: '#6a0080',
      contrastText: '#ffffff',
    },
    error: {
      main: '#d32f2f', // Error color
    },
    background: {
      default: '#4a5759', // Background color
      paper: '#ffffff', // Paper component background
    },
    text: {
      primary: '#dedbd2', // Default text color
      secondary: '#f7e1d7', // Secondary text color
    },
  },
  typography: {
    fontFamily: "'Roboto', 'Helvetica', 'Arial', sans-serif",
    h1: {
      fontSize: '3rem',
      fontWeight: 700,
    },
    h2: {
      fontSize: '2.5rem',
      fontWeight: 600,
    },
    body1: {
      fontSize: '1rem',
      lineHeight: 1.5,
    },
  },
  spacing: 8, // Default spacing unit (8px)
});

export default theme;
