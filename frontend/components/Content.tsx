'use client';

import { useState } from "react";
import { useRouter } from 'next/navigation'

import { Modal } from "@components";

import { translateLanguage, translateType } from "@utils";

import { ContentProps } from "@types";

const Content = ({content}: ContentProps) => {
  const router = useRouter();

  const { extId, language, overview, title, type} = content;

  const [showModal, setShowModal] = useState<boolean>(false);

  const goToContent = (extId: string) => {
    router.push(`/content/${extId}`);
  }

  return (
    <>
      <div className='border border-black w-[300px] min-h-[200px] mt-4 rounded-xl p-4 gap-4 cursor-pointer'
        onClick={() => {
          //setShowModal(true);
          goToContent(`${extId}`);
        }}
      >
        <div className='text-black text-2xl font-bold'>#{extId} - {!!title ? title : 'Sem título'}</div>
        <div className='text-black mt-2 mb-2 text-sm'>{overview.substring(0, 100)}{overview.length > 100 && '...'}</div>
        <div className='text-black flex flex-row gap-1'>
          <div className='font-bold'>Tipo de conteúdo:</div>
          <div className='text-black'>{translateType({ type })}</div>
        </div>
      </div>

      {showModal && (
        <Modal
          content={content}
          onClose={() => {
            setShowModal(false);
          }}
          showModal={showModal}
        />
      )}
    </>
  )
}

export default Content;