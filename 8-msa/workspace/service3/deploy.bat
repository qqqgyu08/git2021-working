scp -i "E:\keyfile\myworkspace.pem" -r ./build/libs/*.jar ubuntu@ec2-52-78-167-183.ap-northeast-2.compute.amazonaws.com:/home/ubuntu/app/myworkspace
scp -i "E:\keyfile\myworkspace.pem" -r ./run.sh ubuntu@ec2-52-78-167-183.ap-northeast-2.compute.amazonaws.com:/home/ubuntu/app/myworkspace
ssh -i "E:\keyfile\myworkspace.pem" ubuntu@ec2-52-78-167-183.ap-northeast-2.compute.amazonaws.com "sudo chmod 777 /home/ubuntu/app/myworkspace/run.sh"
ssh -i "E:\keyfile\myworkspace.pem" ubuntu@ec2-52-78-167-183.ap-northeast-2.compute.amazonaws.com "cd /home/ubuntu/app/myworkspace; ./run.sh myworkspace"