# Build stage
FROM node:18 as build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

# Nginx stage
FROM nginx:latest
COPY --from=build /app/build /usr/share/nginx/html
