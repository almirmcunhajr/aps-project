'use client';

import { useRouter } from 'next/navigation'

import { CardProps } from '@/types'

import { translateLanguage, translateType } from '@utils';

const Card = ({extId, language ,overview, title, type}: CardProps) => {
  const router = useRouter();

  const goToContent = (extId: string) => {
    router.push(`/content/${extId}`);
  }

  return (
    <div onClick={() => goToContent(extId)} className='flex flex-col flex-1 cursor-pointer border border-black p-4 rounded-xl gap-4 mt-2 mb-2 w-full'>
      <div className='text-black text-2xl font-bold'>#{extId} - {title}</div>
      <div className='text-black mt-2 mb-2 text-sm'>{overview}</div>
      <div className='text-black flex flex-row gap-1'>
        <div className='font-bold'>Tipo de conteúdo:</div>
        <div className='text-black'>{translateType({ type })}</div>
      </div>
      <div className='text-black flex flex-row gap-1'>
        <div className='font-bold'>Idioma:</div>
        <div className='text-black'>{translateLanguage({ language })}</div>
      </div>
    </div>
  )
}

export default Card