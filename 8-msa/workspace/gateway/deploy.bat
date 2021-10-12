scp -i "E:\keyfile\gateway.pem" -r ./build/libs/*.jar ubuntu@ec2-3-34-134-169.ap-northeast-2.compute.amazonaws.com:/home/ubuntu/app/gateway
scp -i "E:\keyfile\gateway.pem" -r ./run.sh ubuntu@ec2-3-34-134-169.ap-northeast-2.compute.amazonaws.com:/home/ubuntu/app/gateway
ssh -i "E:\keyfile\gateway.pem" ubuntu@ec2-3-34-134-169.ap-northeast-2.compute.amazonaws.com "sudo chmod 777 /home/ubuntu/app/gateway/run.sh"
ssh -i "E:\keyfile\gateway.pem" ubuntu@ec2-3-34-134-169.ap-northeast-2.compute.amazonaws.com "cd /home/ubuntu/app/gateway; ./run.sh gateway"