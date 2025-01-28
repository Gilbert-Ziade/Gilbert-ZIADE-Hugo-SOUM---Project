# Use Nginx to serve the app
FROM nginx:alpine

# Set the working directory
WORKDIR /usr/share/nginx/html

# Copy the production build
COPY dist /usr/share/nginx/html

# Add Nginx configuration for SPA (if needed)
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Expose port 80
EXPOSE 80

# Run Nginx
CMD ["nginx", "-g", "daemon off;"]
