# Use node 12 as base image
FROM node:12

# Create app directory
WORKDIR /usr/src/app

# Copy app dependencies
COPY package.json .

# Install dependencies
RUN npm install

# Bundle app source
COPY . .

# Run the solution. Your package.json should have start script that invokes
# your code
CMD ["npm", "start"]
