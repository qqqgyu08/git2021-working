import { useRef } from "react";
import { useSelector } from "react-redux";
import { RootState } from "../../store";
import { FeedItemState } from "./type";

interface ModalProp {
  item: FeedItemState;
  onClose: () => void;
  onSave: (editItem: FeedItemState) => void;
}

const FeedEditModal = ({ item, onClose, onSave }: ModalProp) => {
  const profile = useSelector((state: RootState) => state.profile);

  const textRef = useRef<HTMLTextAreaElement>(null);
  const fileRef = useRef<HTMLInputElement>(null);
  // const inputRef = useRef<HTMLInputElement>(null);

  const save = () => {
    if (fileRef.current?.files?.length) {
      const file = fileRef.current?.files[0];
      const reader = new FileReader();
      reader.readAsDataURL(file);

      reader.onload = () => {
        post(reader.result?.toString(), file.type);
      };

      const post = (
        dataUrl: string | undefined,
        fileType: string | undefined
      ) => {
        const feed: FeedItemState = {
          id: item.id,
          content: textRef.current?.value,
          fileType: fileType,
          dataUrl: dataUrl,
          image: profile.image,
          username: profile.username,
          createTime: item.createTime,
          modifyTime: item.modifyTime,
        };
        onSave(feed);
      };
    } else if (textRef.current?.value) {
      const feed: FeedItemState = {
        id: item.id,
        content: textRef.current?.value,
        fileType: item.fileType,
        dataUrl: item.dataUrl,
        image: profile.image,
        username: profile.username,
        createTime: item.createTime,
        modifyTime: item.modifyTime,
      };
      onSave(feed);
    }
  }; //save
  return (
    <div
      className="modal d-block"
      style={{ backgroundColor: "rgba(0, 0, 0, 0.5)" }}
      onClick={() => {
        //배경눌러도 닫히기
        onClose();
      }}
    >
      <div className="modal-dialog">
        <div className="modal-content" onClick={(e) => e.stopPropagation()}>
          <div className="modal-header">
            <h5 className="modal-title">EDIT FEED</h5>
            <button
              type="button"
              className="btn-close"
              aria-label="Close"
              onClick={() => {
                onClose();
              }}
            ></button>
          </div>

          <div className="modal-body">
            <div key={item.id}>
              {item.fileType &&
                (item.fileType?.includes("image") ? (
                  <img
                    className="card-img-top"
                    src={item.dataUrl}
                    alt={item.content}
                  />
                ) : (
                  <video className="card-img-top" controls>
                    <source src={item.dataUrl} type="video/mp4"></source>
                  </video>
                ))}
            </div>
            <textarea
              className="w-100"
              defaultValue={item.content}
              ref={textRef}
            ></textarea>
            <input
              type="file"
              className="form-control me-1"
              // defaultValue={item.dataUrl}
              accept="image/png, image/jpeg, video/mp4"
              ref={fileRef}
            />
          </div>

          <div className="modal-footer">
            <button
              type="button"
              className="btn btn-secondary"
              onClick={() => {
                onClose();
              }}
            >
              닫기
            </button>
            <button
              type="button"
              className="btn btn-primary"
              onClick={() => {
                save();
              }}
            >
              저장
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default FeedEditModal;
