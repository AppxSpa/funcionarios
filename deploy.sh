sudo docker stop funcionarios-container 2>/dev/null
sudo docker rm funcionarios-container 2>/dev/null

sudo docker build -t funcionarios .

sudo docker run \
           --restart always \
           -d -p 8089:8089 \
           --env-file .env \
           --network appx \
           --add-host=host.docker.internal:host-gateway \
           --name funcionarios-container funcionarios
