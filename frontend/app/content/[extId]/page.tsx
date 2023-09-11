'use client';

import { useEffect, useState } from "react";

import { ContentType } from "@types";

const Content = ({ params }: { params: { extId: string } }) => {
  const extId = params.extId;

  const [loading, setLoading] = useState<boolean>(true);
  const [content, setContent] = useState<ContentType>();

  useEffect(() => {
    
    setLoading(false);
  }, []);

  return (
    <div className='min-h-screen flex-1 flex-row flex justify-center items-center'>
      <div className='flex-1 flex-col flex justify-center items-center pt-36 sm:px-16 px-6 max-w-[1440px] gap-4'>
      {loading ? (
          <div>Carregando...</div>
        ) : (
          <>
            <div className="flex-1 flex-row w-full max-w-[1440px]">
              <h1 className='text-4xl font-extrabold flex'>{content?.title}</h1>
            </div>

            <p>{content?.overview}</p>
            <div className="flex-1 flex-row w-full max-w-[1440px]">
              <p>Gêneros: {content?.genres?.join(', ')}</p>
            </div>
          </>
        )}
      </div>
    </div>
  )
}

export default Content;