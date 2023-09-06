'use client';

import { ButtonProps } from '@/types';

const CustomButton = ({ containerStyles, handleClick, icon, title, type}: ButtonProps) => {
  return (
    <button
      className={containerStyles}
      disabled={false}
      onClick={handleClick}
      type={type}
    >
      <span className='flex-1'>
        {icon ?? title}
      </span>
    </button>
  )
}

export default CustomButton