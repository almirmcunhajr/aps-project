'use client';

import React from "react";
import ReactDOM from "react-dom";

import { translateLanguage, translateType } from "@utils";

import { ModalProps } from "@types";

import { MdStarOutline, MdThumbUp, MdThumbUpOffAlt, MdThumbDownOffAlt, MdClose } from 'react-icons/md';

const Modal = ({ content, onClose }: ModalProps) => {
  const { language, overview, title, type} = content;

  const handleCloseClick = (e: React.MouseEvent<HTMLElement>) => {
    e.preventDefault();
    onClose();
  };

  const modalContent = (
    <div className="absolute top-0 left-0 h-[100%] w-[100%] flex justify-center items-center bg-black/50">
      <div className="w-[500px] h-[600px]">
        <div className="bg-white h-[100%] w-[100%] rounded-2xl p-4">
          <div className="flex justify-between p-4 items-center"> 
            <div className="flex flex-row gap-2 items-center justify-start">
              <div className="pl-2 pr-2 cursor-pointer hover:bg-slate-100 rounded-full">
                <MdStarOutline
                  size={28}
                />
              </div>
              <h1 className='text-black text-2xl font-bold'>{!!title ? title : 'Sem título'}</h1>
            </div>
            <a href="#" onClick={handleCloseClick}>
              <MdClose 
                size={28}
              />
            </a>
          </div>
          <div className='mt-4 rounded-xl p-4 gap-4 flex flex-col'>
            <div className='text-black mt-2 mb-2 text-sm'>{overview}</div>
            <div className='text-black flex flex-row gap-1'>
              <div className='font-bold'>Tipo de conteúdo:</div>
              <div className='text-black'>{translateType({ type })}</div>
            </div>
            <div className='text-black flex flex-row gap-1'>
              <div className='font-bold'>Idioma:</div>
              <div className='text-black'>{translateLanguage({ language })}</div>
            </div>
            <div className="flex flex-row justify-end gap-4">
              <div className="pl-2 pr-2 cursor-pointer hover:bg-slate-100 rounded-full">
                <MdThumbUpOffAlt className="cursor-pointer"
                  size={28}
                />
              </div>
              <div className="pl-2 pr-2 cursor-pointer hover:bg-slate-100 rounded-full">
                <MdThumbDownOffAlt
                  size={28}
                />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );

  return ReactDOM.createPortal(
    modalContent,
    document.getElementById("modal-root")!
  );
};

export default Modal