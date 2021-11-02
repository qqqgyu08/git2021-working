
export interface ImageItemResponse {
id: number;
title: string;
imageUrl: string;
fileType: string;
fileName: string;
}

export interface ImageItemRequest {
title : string;
imageUrl : string;
fileType : string;
fileName : string;
}

const imageApi = {
  get : () => (),
  fetch : () => (),

}

export default imageApi;