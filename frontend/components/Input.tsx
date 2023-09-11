'use client';

import { InputProps } from "@/types"

const Input = ({
  autocomplete = 'on',
  containerStyles = '',
  onChange,
  placeholder,
  type = 'text',
  value
}: InputProps) => {
  return (
    <input className={`h-10 rounded-md border border-primary-blue pl-2 ${containerStyles}`}
      autoComplete={autocomplete}
      onChange={(e) => onChange(e.target.value)}
      placeholder={placeholder}
      type={type}
      value={value}
    />
  )
}

export default Input