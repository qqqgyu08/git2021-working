// 1건에 대한 타입

interface FeedItemState {
  id: number;
  content?: string | undefined;
  dataUrl?: string | undefined;
  fileType?: string | undefined;
  image: string | undefined;
  username: string | undefined;
  createTime: number;
  modifyTime?: number;
  isEdit?: boolean;
}

export type { FeedItemState };
